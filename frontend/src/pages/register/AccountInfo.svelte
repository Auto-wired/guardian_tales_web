<script lang="ts">
let accountEntity: AccountEntity;
let updateStep: (step: number) => void;

export { accountEntity, updateStep };

import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";

import nicknameIcon from "@images/icon/nickname.png";
import emailIcon from "@images/icon/email.png";
import verifyIcon from "@images/icon/verify.png";

import type AccountEntity from "@entities/AccountEntity.ts";

let nicknameInput: HTMLInputElement;
let emailInput: HTMLInputElement;
let verifyInput: HTMLInputElement;
let verificationCode: string = "";
let isSendVerificationCode: boolean = false;

function sendVerificationCode (): void {
    isSendVerificationCode = true;
}

function nextProcess (): void {
    updateStep(2);
}
</script>

<div id="account-info">
    <div id="nickname-container">
        <div class="input-title">
            <img src={ nicknameIcon } alt="nickname_icon">
            <p>Nickname</p>
        </div>
        <Input bind:value={ accountEntity.nickname } bind:ref={ nicknameInput } type="text" placeholder="Nickname"></Input>
    </div>
    <div id="email-container">
        <div class="input-title">
            <img src={ emailIcon } alt="email_icon">
            <p>Email</p>
        </div>
        <Input bind:value={ accountEntity.email } bind:ref={ emailInput } type="text" placeholder="Email"></Input>
    </div>
    <div id="verify-container">
        <div class="input-title">
            <img src={ verifyIcon } alt="verify_icon">
            <p>Verification code verify</p>
        </div>
        <Input bind:value={ verificationCode } bind:ref={ verifyInput } type="text" placeholder="Verification code"></Input>
    </div>
    <div id="button-container">
        <Button event={ () => updateStep(0) }>Prev</Button>
        { #if !isSendVerificationCode }
            <Button event={ sendVerificationCode }>Verify email</Button>
        { :else }
            <Button event={ nextProcess }>Register</Button>
        { /if }
    </div>
</div>

<style>
#email-container, #verify-container {
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

.input-title > p {
    font-weight: bold;
}

#button-container {
    display: flex;
    justify-content: space-between;
}

:global(#account-info .button) {
    width: 140px;
}
</style>