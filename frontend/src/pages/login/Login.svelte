<script lang="ts">
import usernameIcon from "@images/icon/username.png";
import passwordIcon from "@images/icon/password.png";

import { Link } from "svelte-routing";

import TranslucenceContainer from "@components/TranslucenceContainer.svelte";
import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";

import AccountEntity from "@entities/AccountEntity.ts";

const accountEntity: AccountEntity = new AccountEntity("", "");

let usernameInput: HTMLInputElement;
let passwordInput: HTMLInputElement;

function loginProcess (): void {

}
</script>

<div id="login">
    <h1 class="title">LOGIN</h1>
    <div id="login-container">
        <TranslucenceContainer>
            <div id="id-container">
                <div class="input-title">
                    <img src={ usernameIcon } alt="username_icon">
                    <p>Username</p>
                </div>
                <Input bind:value={ accountEntity.username } bind:ref={ usernameInput } type="text" placeholder="Username"></Input>
            </div>
            <div id="password-container">
                <div class="input-title">
                    <img src={ passwordIcon } alt="password_icon">
                    <p>Password</p>
                </div>
                <Input bind:value={ accountEntity.password } bind:ref={ passwordInput } type="password" placeholder="Password"></Input>
            </div>
            <Button event={ loginProcess }>Login</Button>
            <div id="link-container">
                <Link to="/forgot-account" class="link">Forgot account?</Link>
                <Link to="/register" class="link">Create an account</Link>
            </div>
        </TranslucenceContainer>
    </div>
</div>

<style>
#login {
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

#password-container {
    margin-top: 24px;
}

:global(#login .input) {
    width: 300px;
}

:global(#login .input:placeholder-shown) {
    transition: background-color .5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#login .input, #login .input:hover, #login .input:focus) {
    background-color: rgba(255, 255, 255, 0.7);
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

.input-title > p, :global(#login .button) {
    font-weight: bold;
}

:global(#login .button) {
    width: 300px;
    margin-top: 24px;
    transition: background-color .5s, color .5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#login .button:hover) {
    color: #ffffff;
    background-color: #000000;
}

#link-container {
    margin-top: 24px;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 8px;
}

:global(#login .link) {
    font-size: 14px;
    font-weight: bold;
    transition: text-shadow .5s;
    color: #000000;
}

:global(#login .link:hover) {
    text-shadow: -1px 0px #ffffff, 0px 1px #ffffff, 1px 0px #ffffff, 0px -1px #ffffff;
}
</style>