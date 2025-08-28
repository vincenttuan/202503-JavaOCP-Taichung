/*
    透過子組件分出 TableHeader, TableBody 與 TableFooter 來組成整個 Table
    讓元件結構更清晰易於維護
*/

// 表頭
function TableHeader() {
    return(
        <thead>
            <tr>
                <th>id</th><th>category</th><th>name</th><th>price</th><th>qty</th><th>subtotal</th>
            </tr>
        </thead>
    )
}

// 表身
function TableBody({products}) {
    return(
        <tbody>
            {
                products.map((product, index) => (
                    <tr key={product.id}>
                        <td>{product.id}</td>
                        <td>{product.category}</td>
                        <td>{product.name}</td>
                        <td align="right">{product.price}</td>
                        <td align="right">{product.qty}</td>
                        <td align="right">{product.price*product.qty}</td>
                    </tr>
                ))
            }
        </tbody>
    )
}

function App() {
    const products = [
        { id: 1, name: '蘋果', price: 40, category: '水果', qty:2 },
        { id: 2, name: '洗髮精', price: 120, category: '日用品', qty:4 },
        { id: 3, name: '香蕉', price: 55, category: '水果', qty:6 },
        { id: 4, name: '牙膏', price: 45, category: '日用品', qty:8 }
    ];

    const total = products.reduce((sum, product) => sum + product.price*product.qty, 0);

    return(
        <>
            <h1>商品資訊</h1>
            <table class="pure-table pure-table-bordered">
                <TableHeader />
                <TableBody products={products} />
                <tfoot>
                    <tr style={{backgroundColor:'#CCCCCC'}}>
                        <td colSpan="5" align="right">總價</td><td align="right">{total.toLocaleString()}</td>
                    </tr>
                </tfoot>    
            </table>
        </>
    )

}

export default App;