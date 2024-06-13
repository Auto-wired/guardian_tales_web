<script lang="ts">
import usernameIcon from "@images/icon/username.png";
import passwordIcon from "@images/icon/password.png";

import { Link } from "svelte-routing";

import TranslucenceContainer from "@components/TranslucenceContainer.svelte";
import Input from "@components/Input.svelte";
import Button from "@components/Button.svelte";

import AccountEntity from "@entities/AccountEntity.ts";

const accountEntity: AccountEntity = new AccountEntity();

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
                <Input
                    bind:value={ accountEntity.username }
                    bind:ref={ usernameInput }
                    type="text"
                    placeholder="Username"
                    icon={ usernameIcon }
                />
                <p class="warning-text"></p>
            </div>
            <div id="password-container">
                <Input
                    bind:value={ accountEntity.password }
                    bind:ref={ passwordInput }
                    type="password"
                    placeholder="Password"
                    icon={ passwordIcon }
                />
                <p class="warning-text"></p>
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

.warning-text {
    height: 24px;
    margin-top: 4px;
    font-size: 11px;
    font-weight: bold;
    color: #ff0000;
}

#link-container {
    margin-top: 30px;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 8px;
}

:global(#login input) {
    width: 300px;
}

:global(#login input:placeholder-shown) {
    transition: background-color .5s;
    background-color: rgba(255, 255, 255, 0.1);
}

:global(#login input, #login input:hover, #login input:focus) {
    background-color: rgba(255, 255, 255, 0.7);
}

:global(#login button) {
    width: 300px;
    font-weight: bold;
    color: #ffffff;
    background-color: #000000;
    transition: box-shadow .5s;
}

:global(#login button:hover) {
    box-shadow: 0px 0px 20px 1px #000000;
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