<script lang="ts">
import verificationCodeIcon from "@images/icon/verification_code.png";

import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";
import TranslucenceContainer from "@components/TranslucenceContainer.svelte";

const verificationCodeList: Array<string> = new Array<string>(8);

function print (): void {
    console.log(verificationCodeList);
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
                    on:onInput={ print }
                    bind:value={ verificationCode }
                />
            {/each }
        </div>
        <Button event={ () => {} }>Verify</Button>
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
    height: 48px;
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