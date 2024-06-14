import Entity from "./Entity.ts";

export default class AccountEntity extends Entity {

    public username: string;
    public password: string;
    public confirmPassword: string;
    public nickname: string;
    public email: string;
    public profileImage: string;

    constructor (username: string = "", password: string = "", nickname: string = "", email: string = "", profileImage: string = "") {
        super();

        this.username = username;
        this.password = password;
        this.confirmPassword = "";
        this.nickname = nickname;
        this.email = email;
        this.profileImage = profileImage;
    }

    public validateUsername (): string {
        if (this.validateLength(this.username, 8, 20)) {
            return "아이디는 8자 이상, 20자 이하로 입력해 주세요.";
        } else if (/[^a-zA-Z0-9]/g.test(this.username)) {
            return "아이디는 영문, 숫자 조합으로만 생성 가능합니다."
        }

        return "";
    }

    public validatePassword (): string {
        if (this.validateLength(this.password, 8, 20)) {
            return "비밀번호는 8자 이상, 20자 이하로 입력해 주세요.";
        }

        return "";
    }

    public validateConfirmPassword (): string {
        if (this.confirmPassword.length === 0) {
            return "비밀번호 확인을 입력해 주세요.";
        } else if (this.confirmPassword !== this.password) {
            return "비밀번호와 비밀번호 확인이 일치하지 않습니다.";
        }
    
        return "";
    }

    public validateNickname (): string {
        if (this.validateLength(this.nickname, 1, 20)) {
            return "닉네임은 20자 이하로 입력해 주세요.";
        }

        return "";
    }

    public validateEmail (): string {
        if (this.validateLength(this.email, 1, 30)) {
            return "이메일은 30자 이하로 입력해 주세요.";
        } else if (!/^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/.test(this.email)) {
            return "이메일을 양식에 맞게 입력해 주세요.";
        }

        return "";
    }

}