import { readFile, writeFile } from "node:fs/promises";

const FEED_URL = "https://www.awesome-testing.com/feed.xml";
const README_PATH = "README.md";
const SECTION_START = "## AI & Agentic Testing";
const START = "<!-- AI-POST-LIST:START -->";
const END = "<!-- AI-POST-LIST:END -->";
const MAX_POSTS = 20;

function getTagValue(block, tag) {
  const cdata = block.match(
    new RegExp(`<${tag}><!\\[CDATA\\[(.*?)\\]\\]><\\/${tag}>`, "s"),
  );
  if (cdata) return cdata[1].trim();
  const plain = block.match(new RegExp(`<${tag}>(.*?)<\\/${tag}>`, "s"));
  return plain ? plain[1].trim() : "";
}

function buildLine(item) {
  return `- [${item.title}](${item.link})`;
}

async function main() {
  const xml = await fetch(FEED_URL).then((r) => {
    if (!r.ok) throw new Error(`Failed to fetch feed: ${r.status}`);
    return r.text();
  });

  const itemBlocks = [...xml.matchAll(/<item>([\s\S]*?)<\/item>/g)].map((m) => m[1]);

  const items = itemBlocks
    .slice(0, MAX_POSTS)
    .map((block) => ({
      title: getTagValue(block, "title"),
      link: getTagValue(block, "link"),
    }))
    .filter((item) => item.title && item.link);

  const lines = items.map(buildLine).join("\n");
  const readme = await readFile(README_PATH, "utf8");

  if (!readme.includes(SECTION_START)) {
    throw new Error(`README.md is missing section: ${SECTION_START}`);
  }

  const markerPattern = new RegExp(`${START}[\\s\\S]*?${END}`, "m");
  if (!markerPattern.test(readme)) {
    throw new Error(`README.md is missing markers:\n${START}\n${END}`);
  }

  const updated = readme.replace(markerPattern, `${START}\n${lines}\n${END}`);
  await writeFile(README_PATH, updated, "utf8");

  console.log(`Updated ${README_PATH} AI archive with ${items.length} posts.`);
}

main().catch((err) => {
  console.error(err);
  process.exit(1);
});
