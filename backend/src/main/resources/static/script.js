async function generateMaze() {
    const response = await fetch('/api/maze/generate?rows=21&cols=21');
    const data = await response.json();
    const grid = data.grid;
    const steps = data.steps;

    const mazeDiv = document.getElementById('maze');
    mazeDiv.innerHTML = '';
    mazeDiv.style.gridTemplateColumns = `repeat(${grid.cols}, 20px)`;

    const cellDivs = [];

    // Побудова порожньої сітки (все — стіни)
    for (let r = 0; r < grid.rows; r++) {
        cellDivs[r] = [];
        for (let c = 0; c < grid.cols; c++) {
            const cellDiv = document.createElement('div');
            cellDiv.classList.add('cell', 'wall'); // Все починається як стіна
            mazeDiv.appendChild(cellDiv);
            cellDivs[r][c] = cellDiv;
        }
    }

    // Поступове відкривання проходів
    let i = 0;
    const interval = setInterval(() => {
        if (i >= steps.length) {
            clearInterval(interval);
            return;
        }

        const step = steps[i];
        const div = cellDivs[step.row][step.col];
        div.classList.remove('wall');
        div.classList.add('path', 'step'); // додаємо ефект "малювання"

        // ефект жовтого підсвічування
        setTimeout(() => {
            div.classList.remove('step');
        }, 100);

        i++;
    }, 20); // швидкість анімації
}
