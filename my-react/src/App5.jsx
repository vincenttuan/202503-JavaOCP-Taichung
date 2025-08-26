// 物件陣列
function App() {
    const fruits = [
        {id:1, name:"西瓜", price:150, qty:1},
        {id:2, name:"芒果", price:80, qty:3},
        {id:3, name:"荔枝", price:200, qty:2},
        {id:4, name:"龍眼", price:100, qty:4},
        {id:5, name:"椰子", price:70, qty:5}
    ];

    // 總計使用 reduce
    const total = fruits.reduce((sum, fruit) => sum + fruit.price*fruit.qty, 0);

    return(
        <>
            {
                fruits.map((fruit, index) => (
                    <div key={fruit.id}>
                        {index} {fruit.id} {fruit.name} {fruit.price} {fruit.qty} {fruit.price*fruit.qty}
                    </div>
                ))
            }
            總計: {total}
        </>
    )

}

export default App;
