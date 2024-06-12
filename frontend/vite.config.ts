import { defineConfig } from "vite";
import { svelte } from "@sveltejs/vite-plugin-svelte";

export default defineConfig({
    plugins: [
        svelte(),
    ],
    resolve: {
        alias: {
            "@": "/src",
            "@images": "/src/assets/images/",
            "@components": "/src/components/",
            "@entities": "/src/entities/",
            "@layouts": "/src/layouts/",
        },
    },
});
