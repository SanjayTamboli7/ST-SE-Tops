function GetProductData()
{
    const ProductData = 
    [
        {ProductName:"Chopper", ProductImage:"image/Chopper.jpg", ProductUnitPrice:129},
        {ProductName:"DinnerSet", ProductImage:"image/DinnerSet.jpg", ProductUnitPrice:219},
        {ProductName:"Kadhai", ProductImage:"image/Kadhai.jpg", ProductUnitPrice:309},
        {ProductName:"Pan", ProductImage:"image/Pan.jpg", ProductUnitPrice:229},
        {ProductName:"Pressure-Cooker", ProductImage:"image/Pressure-Cooker.jpg", ProductUnitPrice:359}
    ]
    
    const LineData = ProductData.map((Value)=>{
        return Value.ProductImage + " " + Value.ProductName + " " + Value.ProductUnitPrice
    })

    document.getElementById("RowData").innerHTML = LineData;

    console.log(LineData);
    // const data =  details.map((v)=>{
    //     return v.name +" "+ v.course
    // })
    
}