import Entity from "./Entity.ts";

export default class AccountEntity extends Entity {

    public username: string;
    public password: string;

    constructor (username: string, password: string) {
        super();

        this.username = username;
        this.password = password;
    }

    public validateUsername (): string {
        if (this.validateLength(this.username, 8, 20)) {
            return "아이디는 8자 이상 20자 이하로 입력해주세요.";
        }

        return "";
    }

    public validatePassword (): string {
        if (this.validateLength(this.password, 8, 20)) {
            return "비밀번호는 8자 이상 20자 이하로 입력해주세요.";
        }

        return "";
    }

}