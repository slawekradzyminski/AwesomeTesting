package com.awesome.testing.api.juice.admin;

public class AdminRegisterResultDto {

    private String status;
    private Data data;

    public AdminRegisterResultDto() {

    }

    public AdminRegisterResultDto(String status, Data data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Data data) {
        this.data = data;
    }

    class Data {

        private String username;
        private String lastLoginIp;
        private String profileImage;
        private boolean isActive;
        private int id;
        private String email;
        private boolean isAdmin;
        private String updatedAt;
        private String createdAt;
        private String deletedAt;

        public Data() {

        }

        public Data(String username, String lastLoginIp, String profileImage, boolean isActive, int id,
                    String email, boolean isAdmin, String updatedAt, String createdAt, String deletedAt) {
            this.username = username;
            this.lastLoginIp = lastLoginIp;
            this.profileImage = profileImage;
            this.isActive = isActive;
            this.id = id;
            this.email = email;
            this.isAdmin = isAdmin;
            this.updatedAt = updatedAt;
            this.createdAt = createdAt;
            this.deletedAt = deletedAt;
        }

        public String getUsername() {
            return username;
        }

        public String getLastLoginIp() {
            return lastLoginIp;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public boolean getIsActive() {
            return isActive;
        }

        public int getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public boolean getIsAdmin() {
            return isAdmin;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getDeletedAt() {
            return deletedAt;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setLastLoginIp(String lastLoginIp) {
            this.lastLoginIp = lastLoginIp;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public void setIsActive(boolean isActive) {
            this.isActive = isActive;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setIsAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public void setDeletedAt(String deletedAt) {
            this.deletedAt = deletedAt;
        }
    }

}
