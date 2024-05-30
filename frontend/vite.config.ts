import { defineConfig } from "vite";
import { svelte } from "@sveltejs/vite-plugin-svelte";
import path from "path";

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [svelte()],
    resolve: {
        alias: [
            {
                find: "@",
                replacement: path.resolve(__dirname, "src"),
            },
            {
                find: "@images",
                replacement: path.resolve(__dirname, "src/assets/images"),
            },
            {
                find: "@components",
                replacement: path.resolve(__dirname, "src/components"),
            },
        ],
    },
});
