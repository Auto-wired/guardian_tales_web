<script lang="ts">
let value: string;
let ref: HTMLInputElement;
let placeholder: string;
let type: string;

export { value, ref, type, placeholder };

import { createEventDispatcher } from "svelte";

const dispath = createEventDispatcher();

function onInput (event: any): void {
    value = event.target.value;

    dispath("onInput");
}
</script>

<input class="input" value={ value } bind:this={ ref } type={ type } placeholder={ placeholder } on:input={ onInput }>

<style>
input {
    height: 32px;
    padding-left: 12px;
    border: 1px solid #000000;
    border-radius: 4px;
    outline: none;
    transition: focus .5s;
    font-size: 14px;
}

input::placeholder {
    font-size: 14px;
    color: #000000;
}
</style>