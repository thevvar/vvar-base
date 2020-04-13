package io.vvar.base.model;

public class Player {

    private String nickname;

    private int globalScore;

    private String email;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGlobalScore() {
        return globalScore;
    }

    public void setGlobalScore(int globalScore) {
        this.globalScore = globalScore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
