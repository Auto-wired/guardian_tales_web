<script lang="ts">
import usernameIcon from "@images/icon/username.png";
import passwordIcon from "@images/icon/password.png";
import confirmPasswordIcon from "@images/icon/confirm_password.png";
import nicknameIcon from "@images/icon/nickname.png";
import emailIcon from "@images/icon/email.png";

import { Link } from "svelte-routing";

import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";
import TranslucenceContainer from "@components/TranslucenceContainer.svelte";

import AccountEntity from "@entities/AccountEntity.ts";

const accountEntity: AccountEntity = new AccountEntity();

let usernameInput: HTMLInputElement;
let passwordInput: HTMLInputElement;
let confirmPasswordInput: HTMLInputElement;
let nicknameInput: HTMLInputElement;
let emailInput: HTMLInputElement;
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
</script>

<div id="register">
    <h1 class="title">REGISTER</h1>
    <div id="register-container">
        <TranslucenceContainer>
            <div id="id-container">
                <Input 
                    on:onInput={ () => validateUsernameResult = "" }
                    bind:value={ accountEntity.username }
                    bind:ref={ usernameInput }
                    type="text"
                    placeholder="Username"
                    icon={ usernameIcon }
                />
                <p class="warning-text">{ validateUsernameResult }</p>
            </div>
            <div id="password-container">
                <Input
                    on:onInput={ () => validatePasswordResult = "" }
                    bind:value={ accountEntity.password }
                    bind:ref={ passwordInput }
                    type="password"
                    placeholder="Password"
                    icon={ passwordIcon }
                />
                <p class="warning-text">{ validatePasswordResult }</p>
            </div>
            <div id="confirm-password-container">
                <Input
                    on:onInput={ () => validateConfirmPasswordResult = "" }
                    bind:value={ accountEntity.confirmPassword }
                    bind:ref={ confirmPasswordInput }
                    type="password"
                    placeholder="Confirm password"
                    icon={ confirmPasswordIcon }
                />
                <p class="warning-text">{ validateConfirmPasswordResult }</p>
            </div>
            <div id="nickname-container">
                <Input
                    bind:value={ accountEntity.nickname }
                    bind:ref={ nicknameInput }
                    type="text"
                    placeholder="Nickname"
                    icon={ nicknameIcon }
                />
                <p class="warning-text"></p>
            </div>
            <div id="email-container">
                <Input
                    bind:value={ accountEntity.email }
                    bind:ref={ emailInput }
                    type="text"
                    placeholder="Email"
                    icon={ emailIcon }
                />
                <p class="warning-text"></p>
            </div>
            <Button event={ () => {} }>Next</Button>
            <div id="link-container">
                <Link to="/login" class="link">Already have an account?</Link>
            </div>
        </TranslucenceContainer>
    </div>
</div>

<style>
#register {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background: url("@images/background/background.png");
    background-size: cover;
    background-position: center;
}

.title {
    margin-bottom: 24px;
    font-size: 44px;
    text-align: center;
    text-shadow: -1px 0px #ffffff, 0px 1px #ffffff, 1px 0px #ffffff, 0px -1px #ffffff;
}

.warning-text {
    height: 24px;
    margin-top: 4px;
    font-size: 11px;
    font-weight: bold;
    color: #ff0000;
}

#link-container {
    margin-top: 24px;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 8px;
}

:global(#register input) {
    width: 300px;
}

:global(#register input:placeholder-shown) {
    transition: background-color .5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#register input, #register input:hover, #register input:focus) {
    background-color: rgba(255, 255, 255, 0.7);
}

:global(#register button) {
    width: 300px;
    font-weight: bold;
    color: #ffffff;
    background-color: #000000;
    transition: box-shadow .5s;
}

:global(#register button:hover) {
    box-shadow: 0px 0px 20px 1px #000000;
}

:global(#register .link) {
    font-size: 14px;
    font-weight: bold;
    transition: text-shadow .5s;
    color: #000000;
}

:global(#register .link:hover) {
    text-shadow: -1px 0px #ffffff, 0px 1px #ffffff, 1px 0px #ffffff, 0px -1px #ffffff;
}
</style>