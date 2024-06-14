<script lang="ts">
import AccountEntity from "@entities/AccountEntity.ts";

let accountEntity: AccountEntity;

export { accountEntity };

import { createEventDispatcher, type EventDispatcher } from "svelte";

import emailIcon from "@images/icon/email.png";

import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";

const dispath:EventDispatcher<any> = createEventDispatcher();

let emailInput: HTMLInputElement;
let validateEmailResult: string = "";

function onNext (): void {
    validateEmailResult = accountEntity.validateEmail();

    if (validateEmailResult.length > 0) {
        emailInput.focus();

        return;
    }

    dispath("onNext");
}
</script>

<div id="forgot-username">
    <Input
        on:onInput={() => {

        }}
        bind:value={ accountEntity.email }
        bind:ref={ emailInput }
        placeholder="Email"
        icon={ emailIcon }
    />
    <p class="warning-text"></p>
    <Button event={ onNext }>Next</Button>
</div>

<style>
.warning-text {
    height: 24px;
    margin-top: 4px;
    font-size: 11px;
    font-weight: bold;
    color: #ff0000;
}
</style>