async function generateMaze() {
    const rows = 20;
    const cols = 20;
    const response = await fetch(`/api/maze/generate?rows=${rows}&cols=${cols}`);
    const maze = await response.json();
    drawMaze(maze);
}

function drawMaze(maze) {
    const canvas = document.getElementById('mazeCanvas');
    const ctx = canvas.getContext('2d');
    const rows = maze.length;
    const cols = maze[0].length;

    const cellWidth = canvas.width / cols;
    const cellHeight = canvas.height / rows;

    for (let y = 0; y < rows; y++) {
        for (let x = 0; x < cols; x++) {
            ctx.fillStyle = maze[y][x] === 1 ? '#222' : '#fff';
            ctx.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
        }
    }

    ctx.fillStyle = 'green';
    ctx.fillRect(0, 0, cellWidth, cellHeight);

    ctx.fillStyle = 'red';
    ctx.fillRect((cols - 1) * cellWidth, (rows - 1) * cellHeight, cellWidth, cellHeight);
}
