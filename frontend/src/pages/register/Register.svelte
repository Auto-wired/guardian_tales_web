<script lang="ts">
import usernameIcon from "@images/icon/username.png";
import passwordIcon from "@images/icon/password.png";
import confirmPasswordIcon from "@images/icon/confirm_password.png";
import nicknameIcon from "@images/icon/nickname.png";
import emailIcon from "@images/icon/email.png";

import { Link } from "svelte-routing";

import Verify from "@layouts/Verify.svelte";

import TranslucenceContainer from "@components/TranslucenceContainer.svelte";
import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";

import AccountEntity from "@entities/AccountEntity.ts";

import ValidateProperty from "@properties/ValidateProperty.ts";

const accountEntity: AccountEntity = new AccountEntity();

let usernameInput: HTMLInputElement;
let passwordInput: HTMLInputElement;
let confirmPasswordInput: HTMLInputElement;
let nicknameInput: HTMLInputElement;
let emailInput: HTMLInputElement;
let validateUsernameResult: string = "";
let validatePasswordResult: string = "";
let validateConfirmPasswordResult: string = "";
let validateNicknameResult: string = "";
let validateEmailResult: string = "";
let isValidatedAccountEntity: boolean = false;

async function register (): Promise<void> {
    // register code
}

async function validateDuplicateUsername (): Promise<boolean> {
    return true;
}

function onNext (): void {
    if (!validateAccountEntity()) {
        return;
    }

    if (!validateDuplicateUsername()) {
        return;
    }

    isValidatedAccountEntity = true;
}

function validateAccountEntity (): boolean {
    let validateResult: boolean = true;

    validateUsernameResult = accountEntity.validateUsername();
    validatePasswordResult = accountEntity.validatePassword();
    validateConfirmPasswordResult = accountEntity.validateConfirmPassword();
    validateNicknameResult = accountEntity.validateNickname();
    validateEmailResult = accountEntity.validateEmail();

    const validateResultList: Array<ValidateProperty> = [
        new ValidateProperty(validateUsernameResult, usernameInput),
        new ValidateProperty(validatePasswordResult, passwordInput),
        new ValidateProperty(validateConfirmPasswordResult, confirmPasswordInput),
        new ValidateProperty(validateNicknameResult, nicknameInput),
        new ValidateProperty(validateEmailResult, emailInput),
    ];

    for (const validateProperty of validateResultList.reverse()) {
        if (validateProperty.validateResult.length > 0) {
            validateProperty.input.focus();

            validateResult = false;
        }

        setInputStyle(validateProperty.input, validateProperty.validateResult.length === 0);
    }

    return validateResult;
}

function setInputStyle (input: HTMLInputElement, isValidated: boolean): void {
    const color: string = isValidated ? "#5bff5b" : "#ff5b5b";

    input.style.border = `1px solid ${ color }`;
    input.style.boxShadow = `0 0 5px 1px ${ color }`;
}

function clearInputStyle (input: HTMLInputElement): void {
    input.style.border = "1px solid #000000";
    input.style.boxShadow = "0 0 5px 1px #000000";
}
</script>

<div id="register">
    <h1 class="title">REGISTER</h1>
    { #if !isValidatedAccountEntity }
        <div id="register-container">
            <TranslucenceContainer>
                <div id="username-container">
                    <Input 
                        on:onInput={() => {
                            validateUsernameResult = "";

                            clearInputStyle(usernameInput);
                        }}
                        bind:value={ accountEntity.username }
                        bind:ref={ usernameInput }
                        placeholder="Username"
                        icon={ usernameIcon }
                    />
                    <p class="warning-text">{ validateUsernameResult }</p>
                </div>
                <div id="password-container">
                    <Input
                        on:onInput={() => {
                            validatePasswordResult = "";

                            clearInputStyle(passwordInput);
                        }}
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
                        on:onInput={() => {
                            validateConfirmPasswordResult = "";

                            clearInputStyle(confirmPasswordInput);
                        }}
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
                        on:onInput={() => {
                            validateNicknameResult = "";

                            clearInputStyle(nicknameInput);
                        }}
                        bind:value={ accountEntity.nickname }
                        bind:ref={ nicknameInput }
                        placeholder="Nickname"
                        icon={ nicknameIcon }
                    />
                    <p class="warning-text">{ validateNicknameResult }</p>
                </div>
                <div id="email-container">
                    <Input
                        on:onInput={() => {
                            validateEmailResult = "";

                            clearInputStyle(emailInput);
                        }}
                        bind:value={ accountEntity.email }
                        bind:ref={ emailInput }
                        placeholder="Email"
                        icon={ emailIcon }
                    />
                    <p class="warning-text">{ validateEmailResult }</p>
                </div>
                <Button event={ onNext }>Register</Button>
                <div id="link-container">
                    <Link class="link" to="/login">Already have an account?</Link>
                </div>
            </TranslucenceContainer>
        </div>
    { :else }
        <Verify on:success={ register }></Verify>
    { /if }
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
    margin-top: 30px;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 8px;
}

:global(#register input) {
    box-shadow: 0px 0px 5px 1px #000000;
}

:global(#register-container input, #register-container button) {
    width: 300px;
}

:global(#register input:placeholder-shown) {
    transition: background-color 0.5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#register input, #register input:hover, #register input:focus) {
    background-color: rgba(255, 255, 255, 0.7);
}

:global(#register button) {
    font-weight: bold;
    transition: box-shadow 0.5s;
    color: #ffffff;
    background-color: #000000;
}

:global(#register button:hover) {
    box-shadow: 0px 0px 20px 1px #000000;
}

:global(#register .link) {
    font-size: 14px;
    font-weight: bold;
    transition: filter .5s;
    color: #000000;
}

:global(#register .link:hover) {
    filter: drop-shadow(0px 0px 2px #000000);
}
</style>