<script lang="ts">
import emailIcon from "@images/icon/email.png";

import { Link } from "svelte-routing";

import Verify from "@layouts/Verify.svelte";

import TranslucenceContainer from "@components/TranslucenceContainer.svelte";
import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";

import AccountEntity from "@entities/AccountEntity.ts";

const accountEntity: AccountEntity = new AccountEntity;

let emailInput: HTMLInputElement;
let validateEmailResult: string = "";
let isValidatedAccountEntity: boolean = false;

function onNext (): void {
    validateEmailResult = accountEntity.validateEmail();

    if (validateEmailResult.length > 0) {
        emailInput.focus();

        setInputStyle(emailInput, false);

        return;
    }

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

<div id="forgot-username">
    <h1 class="title">FORGOT USERNAME</h1>
    { #if !isValidatedAccountEntity }
        <div id="forgot-username-container">
            <TranslucenceContainer>
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
                <Button event={ onNext }>Next</Button>
                <div id="link-container">
                    <Link class="link" to="/forgot-password">Forgot password?</Link>
                    <Link class="link" to="/login">Back to login</Link>
                </div>
            </TranslucenceContainer>
        </div>
    { :else }
        <Verify></Verify>
    { /if }
</div>

<style>
#forgot-username {
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

:global(#forgot-username input) {
    box-shadow: 0px 0px 5px 1px #000000;
}

:global(#forgot-username-container input, #forgot-username-container button) {
    width: 300px;
}

:global(#forgot-username input:placeholder-shown) {
    transition: background-color 0.5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#forgot-username input, #forgot-username input:hover, #forgot-username input:focus) {
    background-color: rgba(255, 255, 255, 0.7);
}

:global(#forgot-username button) {
    font-weight: bold;
    transition: box-shadow 0.5s;
    color: #ffffff;
    background-color: #000000;
}

:global(#forgot-username button:hover) {
    box-shadow: 0px 0px 20px 1px #000000;
}

:global(#forgot-username .link) {
    font-size: 14px;
    font-weight: bold;
    transition: filter .5s;
    color: #000000;
}

:global(#forgot-username .link:hover) {
    filter: drop-shadow(0px 0px 2px #000000);
}
</style>