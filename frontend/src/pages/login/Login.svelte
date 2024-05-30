<script lang="ts">
import { Link } from "svelte-routing";

import Input from "@components/input/Input.svelte";

import usernameIcon from "@images/icon/username.png";
import passwordIcon from "@images/icon/password.png";
</script>

<div id="login">
    <h1 id="login-title">LOGIN</h1>
    <div id="login-container">
        <div id="input-container">
            <div id="id-container">
                <div class="input-title">
                    <img src={ usernameIcon } alt="">
                    <p>Username</p>
                </div>
                <Input id="id-input" type="text" placeholder="Username"></Input>
            </div>
            <div id="password-container">
                <div class="input-title">
                    <img src={ passwordIcon } alt="">
                    <p>Password</p>
                </div>
                <Input id="password-input" type="password" placeholder="Password"></Input>
            </div>
            <div id="link-container">
                <Link to="/forgot-password" class="link">Forgot password?</Link>
                <Link to="/register" class="link">Create an account</Link> 
            </div>
        </div>
        <div id="login-background"></div>
    </div>
    <!-- <a href="https://www.flaticon.com/kr/free-icons/" title="사용자 아이콘">사용자 아이콘 제작자: Debi Alpa Nugraha - Flaticon</a>
    <a href="https://www.flaticon.com/kr/free-icons/" title="터놓다 아이콘">터놓다 아이콘 제작자: Uniconlabs - Flaticon</a> -->
</div>

<style>
@import url("./Login.css");
</style>