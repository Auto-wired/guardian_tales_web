<script lang="ts">
import { Router, Route, Link } from "svelte-routing";

import Main from "./pages/Main.svelte";
import Login from "./pages/Login.svelte";
import Register from "./pages/Register.svelte";
import NotFound from "./pages/NotFound.svelte";
</script>

<Router url="">
    <Route path="/" component={ Main }></Route>
    <Route path="/login" component={ Login }></Route>
    <Route path="/register" component={ Register }></Route>
    <Route path="*" component={ NotFound }></Route>
</Router>