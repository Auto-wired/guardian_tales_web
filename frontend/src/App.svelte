<script lang="ts">
import { Router, Route, Link } from "svelte-routing";

import Main from "./pages/main/Main.svelte";
import Login from "./pages/login/Login.svelte";
import Register from "./pages/register/Register.svelte";
import ForgotUsername from "./pages/forgot_account/ForgotUsername.svelte";
import ForgotPassword from "./pages/forgot_account/ForgotPassword.svelte";
import NotFound from "./pages/NotFound.svelte";
</script>

<Router>
    <Route path="/" component={ Main }></Route>
    <Route path="/login" component={ Login }></Route>
    <Route path="/register" component={ Register }></Route>
    <Route path="/forgot-username" component={ ForgotUsername }></Route>
    <Route path="/forgot-password" component={ ForgotPassword }></Route>
    <Route path="*" component={ NotFound }></Route>
</Router>