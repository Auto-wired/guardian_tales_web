<script lang="ts">
import logo from "@images/logo.png";

import { onMount } from "svelte";

let notFound: HTMLDivElement;

onMount(() => {
    for (let i: number = 0; i < 10; i++) {
        const lupina: HTMLImageElement = document.createElement("img");

        lupina.src = logo;
        lupina.alt = "logo";
        lupina.style.position = "absolute";
        lupina.style.top = `${ Math.random() * 100 }px`;
        lupina.style.left = `${ Math.random() * 100 }px`;
        lupina.style.animation = "rotate_image 2s linear infinite";
        lupina.style.transformOrigin = "50% 50%";

        notFound.append(lupina);
    }
});
</script>

<div id="not-found" bind:this={ notFound }>
    <h1 class="lupina">NOT FOUND PAGE</h1>
</div>

<style>
#not-found {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

h1 {
    font-size: 100px;
}
</style>