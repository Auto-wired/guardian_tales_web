<script lang="ts">
let value: string;
let ref: HTMLInputElement;
let type: string;
let placeholder: string;
let icon: string;

export { value, ref, type, placeholder, icon };

import { createEventDispatcher } from "svelte";

const dispath = createEventDispatcher();

function onInput (event: any): void {
    value = event.target.value;

    dispath("onInput");
}
</script>

<div class="input">
    <input value={ value } bind:this={ ref } type={ type } placeholder={ placeholder } on:input={ onInput } autocomplete="off">
    <img src={ icon } alt="input_icon">
</div>

<style>
.input {
    position: relative;
}

input {
    height: 32px;
    padding-left: 44px;
    padding-right: 8px;
    border: 1px solid #000000;
    border-radius: 4px;
    outline: none;
    transition: focus .5s;
    font-size: 14px;
}

input::placeholder {
    font-size: 12px;
    color: #000000;
}

img {
    height: 20px;
    padding-right: 8px;
    border-right: 1px solid #000000;
    position: absolute;
    top: 50%;
    left: 8px;
    transform: translateY(-50%);
}
</style>