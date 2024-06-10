<script lang="ts">
let accountEntity: AccountEntity;
let updateStep: (step: number) => void;

export { accountEntity, updateStep };

import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";

import usernameIcon from "@images/icon/username.png";
import passwordIcon from "@images/icon/password.png";

import type AccountEntity from "@entities/AccountEntity.ts";

let usernameInput: HTMLInputElement;
let passwordInput: HTMLInputElement;
let confirmPasswordInput: HTMLInputElement;
let confirmPassword: string = "";

function validateAccount (): boolean {
    const validateUsernameResult: string = accountEntity.validateUsername();
    const validatePasswordResult: string = accountEntity.validatePassword();
    const validateConfirmPasswordResult: string = validateConfirmPassword();

    function validateAccountProcess (validateResult: string, input: HTMLInputElement): boolean {
        if (validateResult.length > 0) {
            alert(validateResult);

            input.focus();

            return false;
        }

        return true;
    }

    return validateAccountProcess(validateUsernameResult, usernameInput) && validateAccountProcess(validatePasswordResult, passwordInput) && validateAccountProcess(validateConfirmPasswordResult, confirmPasswordInput);
}

function validateConfirmPassword (): string {
    if (confirmPassword !== accountEntity.password) {
        return "비밀번호와 비밀번호 확인이 일치하지 않습니다.";
    }

    return "";
}

function nextProcess ():void {
    if (!validateAccount()) {
        return;
    }

    updateStep(1);
}
</script>

<div id="account">
    <div id="id-container">
        <div class="input-title">
            <img src={ usernameIcon } alt="username_icon">
            <p>Username</p>
        </div>
        <Input bind:value={ accountEntity.username } bind:ref={ usernameInput } type="text" placeholder="Username"></Input>
    </div>
    <div id="password-container">
        <div class="input-title">
            <img src={ passwordIcon } alt="password_icon">
            <p>Password</p>
        </div>
        <Input bind:value={ accountEntity.password } bind:ref={ passwordInput } type="password" placeholder="Password"></Input>
    </div>
    <div id="confirm-password-container">
        <div class="input-title">
            <img src={ passwordIcon } alt="password_icon">
            <p>Confirm Password</p>
        </div>
        <Input bind:value={ confirmPassword } bind:ref={ confirmPasswordInput } type="password" placeholder="Password"></Input>
    </div>
    <Button event={ nextProcess }>Next</Button>
</div>

<style>
#password-container, #confirm-password-container {
    margin-top: 24px;
}

.input-title {
    margin-bottom: 8px;
    display: flex;
    align-items: center;
}

.input-title > img {
    width: 24px;
    height: 24px;
    margin-right: 8px;
}

.input-title > p, :global(#register .button) {
    font-weight: bold;
}
</style>