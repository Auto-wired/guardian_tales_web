<script lang="ts">
import verificationCodeIcon from "@images/icon/verification_code.png";

import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";
import TranslucenceContainer from "@components/TranslucenceContainer.svelte";

const verificationCodeList: Array<string> = new Array<string>(8);
const verificationCodeInputList: Array<HTMLInputElement> = new Array<HTMLInputElement>(8);

function onNext (verificationCodeIndex: number): void {
    if (verificationCodeIndex === 7) {
        return;
    }

    let verificationCode: string = verificationCodeList[verificationCodeIndex].substring(0, 1);

    if (/[^a-zA-Z0-9]/.test(verificationCode)) {
        verificationCode = "";
    } else if (/[a-z]/.test(verificationCode)) {
        verificationCode = verificationCode.toUpperCase();
    }

    verificationCodeList[verificationCodeIndex] = verificationCode;

    if (verificationCode.length === 1) {
        verificationCodeInputList[verificationCodeIndex + 1].focus();
    }
}

function validateVerificationCode (): boolean {
    for (let i: number = 0; i < verificationCodeList.length; i++) {
        if (verificationCodeList[i].length === 0) {
            verificationCodeInputList[i].focus();

            alert("코드를 입력해주세요.");

            return false;
        }
    }

    return true;
}

function verify (): void {
    if (!validateVerificationCode()) {
        return;
    }

    const verificationCode: string = verificationCodeList.join("");
}
</script>

<div id="verify">
    <TranslucenceContainer>
        <div id="verify-title">
            <img src={ verificationCodeIcon } alt="verification_code_icon">
            <h1>Please enter the 8-digit code sent by email.</h1>
        </div>
        <div id="verify-container">
            { #each verificationCodeList as verificationCode, verificationCodeIndex }
                <Input
                    on:onInput={ () => onNext(verificationCodeIndex) }
                    bind:value={ verificationCode }
                    bind:ref={ verificationCodeInputList[verificationCodeIndex] }
                />
            {/each }
        </div>
        <Button event={ verify }>Verify</Button>
    </TranslucenceContainer>
</div>

<style>
#verify-container {
    display: flex;
    gap: 8px;
}

#verify-title {
    margin-bottom: 24px;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 12px;
}

img {
    height: 60px;
}

:global(#verify input) {
    width: 50px;
    height: 50px;
    text-align: center;
    font-size: 32px;
    font-weight: bold;
}

:global(#verify button) {
    width: 456px;
    margin-top: 24px;
}
</style>