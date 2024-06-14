<script lang="ts">
import usernameIcon from "@images/icon/username.png";
import passwordIcon from "@images/icon/password.png";

import { Link } from "svelte-routing";

import Verify from "@layouts/Verify.svelte";

import TranslucenceContainer from "@components/TranslucenceContainer.svelte";
import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";

import AccountEntity from "@entities/AccountEntity";

const accountEntity: AccountEntity = new AccountEntity();

let usernameInput: HTMLInputElement;
let passwordInput: HTMLInputElement;
let validateUsernameResult: string = "";
let validatePasswordResult: string = "";
let isValidatedAccountEntity: boolean = false;

function loginProcess (): void {
    if (!validateAccountEntity()) {
        return;
    }

    // login code

    isValidatedAccountEntity = true;
}

function validateAccountEntity (): boolean {
    let validateResult: boolean = true;

    if (accountEntity.username.length === 0) {
        validateUsernameResult = "아이디를 입력해주세요.";

        usernameInput.focus();

        setInputStyle(usernameInput, false);

        validateResult = false;
    } else {
        setInputStyle(usernameInput, true);
    }
    
    if (accountEntity.password.length === 0) {
        validatePasswordResult = "비밀번호를 입력해주세요.";

        passwordInput.focus();

        setInputStyle(passwordInput, false);

        validateResult = false;
    } else {
        setInputStyle(passwordInput, true);
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

<div id="login">
    <h1 class="title">LOGIN</h1>
    { #if !isValidatedAccountEntity }
        <div id="login-container">
            <TranslucenceContainer>
                <div id="id-container">
                    <Input
                        on:onInput={() => {
                            validateUsernameResult = "";

                            clearInputStyle(usernameInput);
                        }}
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
                <Button event={ loginProcess }>Login</Button>
                <div id="link-container">
                    <Link to="/forgot-account" class="link">Forgot account?</Link>
                    <Link to="/register" class="link">Create an account</Link>
                </div>
            </TranslucenceContainer>
        </div>
    { :else }
        <Verify></Verify>
    { /if }
</div>

<style>
#login {
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

:global(#login input) {
    box-shadow: 0 0 5px 1px #000000;
}

:global(#login-container input, #login-container button) {
    width: 300px;
}

:global(#login input:placeholder-shown) {
    transition: background-color .5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#login input, #login input:hover, #login input:focus) {
    background-color: rgba(255, 255, 255, 0.7);
}

:global(#login button) {
    font-weight: bold;
    color: #ffffff;
    background-color: #000000;
    transition: box-shadow .5s;
}

:global(#login button:hover) {
    box-shadow: 0px 0px 20px 1px #000000;
}

:global(#login .link) {
    font-size: 14px;
    font-weight: bold;
    transition: filter .5s;
    color: #000000;
}

:global(#login .link:hover) {
    filter: drop-shadow(0px 0px 2px #000000);
}
</style>