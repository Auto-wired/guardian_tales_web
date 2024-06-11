<script lang="ts">
import { Link } from "svelte-routing";

import Account from "./Account.svelte";
import AccountInfo from "./AccountInfo.svelte";

import TranslucenceContainer from "@components/TranslucenceContainer.svelte";

import AccountEntity from "@entities/AccountEntity.ts";

const accountEntity: AccountEntity = new AccountEntity();

let registerStep: number = 0;

function updateStep (step: number): void {
    registerStep = step;
}
</script>

<div id="register">
    <h1 class="title">REGISTER</h1>
    <div id="register-container">
        <TranslucenceContainer>
            { #if registerStep === 0 }
                <Account accountEntity={ accountEntity } updateStep={ updateStep }></Account>
            { :else if registerStep === 1 }
                <AccountInfo accountEntity={ accountEntity } updateStep={ updateStep }></AccountInfo>
            { /if }
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

#link-container {
    margin-top: 24px;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 8px;
}

:global(#register .input) {
    width: 300px;
}

:global(#register .input:placeholder-shown) {
    transition: background-color .5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#register .input, #register .input:hover, #register .input:focus) {
    background-color: rgba(255, 255, 255, 0.7);
}

:global(#register .button) {
    margin-top: 24px;
    font-weight: bold;
    transition: background-color .5s, color .5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#register .button:hover) {
    color: #ffffff;
    background-color: #000000;
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