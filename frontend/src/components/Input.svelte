<script lang="ts">
let value: string = "";
let ref: HTMLInputElement | null = null;
let type: string = "text";
let placeholder: string = "";
let icon: string = "";

export { value, ref, type, placeholder, icon };

import { createEventDispatcher } from "svelte";

const dispath = createEventDispatcher();

function onInput (event: any): void {
    value = event.target.value;

    dispath("onInput");
}

function onFocus (event: any): void {
    event.target.select();
}
</script>

<div class="input">
    <input class={ icon.length > 0 ? "enable-icon" : "disable-icon" } value={ value } bind:this={ ref } type={ type } placeholder={ placeholder } on:input={ onInput } on:focus={ onFocus } autocomplete="off">
    { #if icon.length > 0 }
        <div class="icon-container">
            <img src={ icon } alt="input_icon">
        </div>
    { /if }
</div>

<style>
.input {
    position: relative;
}

input {
    height: 32px;
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

.enable-icon {
    padding-left: 44px;
}

.disable-icon {
    padding-left: 8px;
}

.icon-container {
    width: 36px;
    height: 32px;
    display: flex;
    justify-content: center;
    align-items: center;
    position: absolute;
    top: 0;
    left: 0;
    pointer-events: none;
}

.icon-container::after {
    width: 1px;
    height: 22px;
    border-right: 2px solid #000000;
    border-radius: 100px;
    content: "";
    position: absolute;
    top: 50%;
    right: -4px;
    transform: translate(-50%, -50%);
}

img {
    height: 20px;
}
</style>