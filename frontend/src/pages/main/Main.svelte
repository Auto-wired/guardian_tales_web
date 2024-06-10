<script lang="ts">

</script>

<div id="main">
    <nav class="menu">
        <p>콜로세움</p>
    </nav>
    <nav class="menu">
        <p>아레나/데스매치</p>
    </nav>
    <nav class="menu">
        <p>테티스 영웅전 Beta</p>
    </nav>
    <nav class="menu">
        <p>길드 레이드</p>
    </nav>
    <nav class="menu">
        <p>보스러시</p>
    </nav>
    <nav class="menu">
        <p>궤도 엘레베이터</p>
    </nav>
    <nav class="menu">
        <p>협동 원정대 Beta/원정대</p>
    </nav>
</div>

<style>
#main {
    width: 100%;
    height: 100%;
    display: grid;
    grid-template-columns: repeat(7, 1fr);
}

.menu {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
}
</style>