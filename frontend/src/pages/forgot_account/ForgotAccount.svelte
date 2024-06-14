<script lang="ts">
import { Link } from "svelte-routing";

import TranslucenceContainer from "@components/TranslucenceContainer.svelte";
import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";

import ForgotUsername from "./ForgotUsername.svelte";
import ForgotPassword from "./ForgotPassword.svelte";

import AccountEntity from "@entities/AccountEntity.ts";

const accountEntity: AccountEntity = new AccountEntity();

let isValidatedAccountEntity: boolean = false;

function onNext (): void {
    // send email code

    isValidatedAccountEntity = true;
}
</script>

<div id="forgot-account">
    <h1 class="title">FORGOT ACCOUNT</h1>
    <div id="forgot-account-container">
        <TranslucenceContainer>
            <ForgotUsername on:onNext={ onNext } accountEntity={ accountEntity }></ForgotUsername>
            <div id="link-container">
                <Link to="/login" class="link">Back to Login</Link>
            </div>
        </TranslucenceContainer>
    </div>
</div>

<style>
#forgot-account {
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

#link-container {
    margin-top: 30px;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 8px;
}

:global(#forgot-account input, #forgot-account button) {
    width: 300px;
}

:global(#forgot-account input) {
    box-shadow: 0 0 5px 1px #000000;
}

:global(#forgot-account input:placeholder-shown) {
    transition: background-color .5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#forgot-account input, #forgot-account input:hover, #forgot-account input:focus) {
    background-color: rgba(255, 255, 255, 0.7);
}

:global(#forgot-account button) {
    font-weight: bold;
    color: #ffffff;
    background-color: #000000;
    transition: box-shadow .5s;
}

:global(#forgot-account button:hover) {
    box-shadow: 0px 0px 20px 1px #000000;
}

:global(#forgot-account .link) {
    font-size: 14px;
    font-weight: bold;
    transition: filter .5s;
    color: #000000;
}

:global(#forgot-account .link:hover) {
    filter: drop-shadow(0px 0px 2px #000000);
}
</style>