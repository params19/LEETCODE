<h2> 9035 2015
130. Surrounded Regions</h2><hr><div><p>You are given an <code>m x n</code> matrix <code>board</code> containing <strong>letters</strong> <code>'X'</code> and <code>'O'</code>, <strong>capture regions</strong> that are <strong>surrounded</strong>:</p>

<ul>
	<li><strong>Connect</strong>: A cell is connected to adjacent cells horizontally or vertically.</li>
	<li><strong>Region</strong>: To form a region <strong>connect every</strong> <code>'O'</code> cell.</li>
	<li><strong>Surround</strong>: The region is surrounded with <code>'X'</code> cells if you can <strong>connect the region </strong>with <code>'X'</code> cells and none of the region cells are on the edge of the <code>board</code>.</li>
</ul>

<p>To capture a <strong>surrounded region</strong>, replace all <code>'O'</code>s with <code>'X'</code>s <strong>in-place</strong> within the original board. You do not need to return anything.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]</span></p>

<p><strong>Explanation:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/xogrid.jpg" style="width: 367px; height: 158px;">
<p>In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">board = [["X"]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["X"]]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n == board[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>board[i][j]</code> is <code>'X'</code> or <code>'O'</code>.</li>
</ul>
</div>