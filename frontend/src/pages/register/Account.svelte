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
let validateUsernameResult: string = "";
let validatePasswordResult: string = "";
let validateConfirmPasswordResult: string = "";

function validateAccount (): boolean {
    validateUsernameResult = accountEntity.validateUsername();
    validatePasswordResult = accountEntity.validatePassword();
    validateConfirmPasswordResult = accountEntity.validateConfirmPassword();

    function validateAccountProcess (validateResult: string, input: HTMLInputElement): boolean {
        if (validateResult.length > 0) {
            input.focus();

            return false;
        }

        return true;
    }

    return validateAccountProcess(validateUsernameResult, usernameInput) && validateAccountProcess(validatePasswordResult, passwordInput) && validateAccountProcess(validateConfirmPasswordResult, confirmPasswordInput);
}

function nextProcess (): void {
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
        <Input on:onInput={ () => validateUsernameResult = "" } bind:value={ accountEntity.username } bind:ref={ usernameInput } type="text" placeholder="Username"></Input>
        <p class="warning-text">{ validateUsernameResult }</p>
    </div>
    <div id="password-container">
        <div class="input-title">
            <img src={ passwordIcon } alt="password_icon">
            <p>Password</p>
        </div>
        <Input on:onInput={ () => validatePasswordResult = "" } bind:value={ accountEntity.password } bind:ref={ passwordInput } type="password" placeholder="Password"></Input>
        <p class="warning-text">{ validatePasswordResult }</p>
    </div>
    <div id="confirm-password-container">
        <div class="input-title">
            <img src={ passwordIcon } alt="password_icon">
            <p>Confirm Password</p>
        </div>
        <Input on:onInput={ () => validateConfirmPasswordResult = "" } bind:value={ accountEntity.confirmPassword } bind:ref={ confirmPasswordInput } type="password" placeholder="Password"></Input>
        <p class="warning-text">{ validateConfirmPasswordResult }</p>
    </div>
    <Button event={ nextProcess }>Next</Button>
</div>

<style>
/* #password-container, #confirm-password-container {
    margin-top: 24px;
} */

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

.input-title > p {
    font-weight: bold;
}

.warning-text {
    height: 24px;
    margin-top: 4px;
    font-size: 12px;
    color: #ff0000;
}

:global(#account .button) {
    width: 300px;
}
</style>