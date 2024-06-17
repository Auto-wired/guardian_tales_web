<script lang="ts">
import usernameIcon from "@images/icon/username.png";
import emailIcon from "@images/icon/email.png";

import { Link } from "svelte-routing";

import Verify from "@layouts/Verify.svelte";

import TranslucenceContainer from "@components/TranslucenceContainer.svelte";
import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";

import AccountEntity from "@entities/AccountEntity.ts";

const accountEntity: AccountEntity = new AccountEntity;

let usernameInput: HTMLInputElement;
let validateUsernameResult: string = "";
let isValidatedAccountEntity: boolean = false;

function onNext (): void {
    if (accountEntity.username.length === 0) {
        validateUsernameResult = "아이디를 입력해주세요.";

        usernameInput.focus();

        setInputStyle(usernameInput, false);

        return;
    }

    // get email
    // send email

    isValidatedAccountEntity = true;
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

<div id="forgot-password">
    <h1 class="title">FORGOT PASSWORD</h1>
    { #if !isValidatedAccountEntity }
        <div id="forgot-password-container">
            <TranslucenceContainer>
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
                <Button event={ onNext }>Next</Button>
                <div id="link-container">
                    <Link class="link" to="/forgot-username">Forgot username?</Link>
                    <Link class="link" to="/login">Back to login</Link>
                </div>
            </TranslucenceContainer>
        </div>
    { :else }
        <Verify></Verify>
    { /if }
</div>

<style>
#forgot-password {
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

.warning-text {
    height: 24px;
    margin-top: 4px;
    font-size: 11px;
    font-weight: bold;
    color: #ff0000;
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

:global(#forgot-password input) {
    box-shadow: 0px 0px 5px 1px #000000;
}

:global(#forgot-password-container input, #forgot-password-container button) {
    width: 300px;
}

:global(#forgot-password input:placeholder-shown) {
    transition: background-color 0.5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#forgot-password input, #forgot-password input:hover, #forgot-password input:focus) {
    background-color: rgba(255, 255, 255, 0.7);
}

:global(#forgot-password button) {
    font-weight: bold;
    transition: box-shadow 0.5s;
    color: #ffffff;
    background-color: #000000;
}

:global(#forgot-password button:hover) {
    box-shadow: 0px 0px 20px 1px #000000;
}

:global(#forgot-password .link) {
    font-size: 14px;
    font-weight: bold;
    transition: filter .5s;
    color: #000000;
}

:global(#forgot-password .link:hover) {
    filter: drop-shadow(0px 0px 2px #000000);
}
</style>