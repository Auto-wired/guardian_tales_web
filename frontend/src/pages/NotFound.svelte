<script lang="ts">
import logo from "@images/logo.png";

import { onMount } from "svelte";

import Lupina from "@properties/LupinaProperty.ts";

const lupinaList: Array<Lupina> = [];
const imageSize: number = 66;

let notFound: HTMLDivElement;

onMount(() => {
    generateLupina();

    setInterval(() => {
        for (let i: number = 0; i < lupinaList.length; i++) {
            const lupina: Lupina = lupinaList[i];

            moveLupina(lupina);
        }
    }, 10);
});

function generateLupina (): void {
    for (let i: number = 0; i < 10; i++) {
        const element: HTMLImageElement = document.createElement("img");
        const { width, height } = document.body.getBoundingClientRect();
        const imageLeft: number = Math.floor(Math.random() * (width - imageSize * 2) + imageSize);
        const imageTop: number = Math.floor(Math.random() * (height - imageSize * 2) + imageSize);
        const speed: number = Math.floor(Math.random() * 9 + 1);

        element.src = logo;
        element.alt = "logo";
        element.style.width = `${ imageSize }px`;
        element.style.height = `${ imageSize }px`;
        element.style.position = "absolute";
        element.style.left = `${ imageLeft }px`;
        element.style.top = `${ imageTop }px`;
        element.style.animation = `rotate_image ${ speed }s linear infinite`;
        element.style.transformOrigin = "50% 50%";
        element.style.cursor = "pointer";
        element.style.userSelect = "none";

        lupinaList.push(new Lupina(element, speed, speed > 5 ? 1 : -1, speed > 5 ? 1 : -1));
        notFound.append(element);
    }
}

function moveLupina (lupina: Lupina): void {
    const { width, height } = document.body.getBoundingClientRect();
    const imageLeft: number = +lupina.element.style.left.replace("px", "");
    const imageTop: number = +lupina.element.style.top.replace("px", "");

    if (imageLeft < 0 || imageLeft > width - imageSize) {
        lupina.directionX *= -1;
    }

    if (imageTop < 0 || imageTop > height - imageSize) {
        lupina.directionY *= -1;
    }

    lupina.element.style.left = `${ imageLeft + lupina.directionX * lupina.speed }px`;
    lupina.element.style.top = `${ imageTop + lupina.directionY * lupina.speed }px`;

    if (imageLeft < 0 || imageLeft > width - imageSize || imageTop < 0 || imageTop > height - imageSize) {
        lupina.speed = Math.floor(Math.random() * 9 + 1);
        lupina.element.style.animation = `rotate_image ${ Math.floor(Math.random() * 9 + 1) }s linear infinite`;
    }
}
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