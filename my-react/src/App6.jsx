/*
隨堂練習
商品資料如下:
    { id: 1, name: '蘋果', price: 40, category: '水果', qty:2 },
    { id: 2, name: '洗髮精', price: 120, category: '日用品', qty:4 },
    { id: 3, name: '香蕉', price: 55, category: '水果', qty:6 },
    { id: 4, name: '牙膏', price: 45, category: '日用品', qty:8 }
請利用 react 將上述商品資料透過 jsx + <table> 標籤呈現並計算總價
*/

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
            <h2>總價:{total.toLocaleString()}</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>id</th><th>category</th><th>name</th><th>price</th><th>qty</th><th>subtotal</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        products.map((product, index) => (
                            <tr key={product.id}>
                                <td>{product.id}</td>
                                <td>{product.category}</td>
                                <td>{product.name}</td>
                                <td>{product.price}</td>
                                <td>{product.qty}</td>
                                <td>{product.price*product.qty}</td>
                            </tr>
                        ))
                    }
                </tbody>

            </table>
        </>
    )

}

export default App;