
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
             <table border="1px">
        <form action="Addtocart" method = "post">
    
            <th>Pizza Name</th> <th>Price</th>  <th>Add to Cart</th>
            <tr><td>Muffuleta</td><td>$20</td><td><input type="hidden" name="name" value="Muffuleta">
            <input type="hidden" name="price" value="20"><input type="submit" value="Add to cart"></td>
        </tr>
        </form>
        <form action="Addtocart" method = "post">
            <tr><td>Veggie Delight</td><td>$40</td><td>
            <input type="hidden" name="name" value="Veggie Delight">
            <input type="hidden" name="price" value="40"><input type="submit" value="Add to cart"></td>
        </tr>  
        </form>
         <form action="Addtocart" method = "post">
            <tr><td>Margherita</td><td>$10</td><td>
            <input type="hidden" name="name" value="margherita">
            <input type="hidden" name="price" value="10"><input type="submit" value="Add to cart"></td>
            </tr>
            
        </form>
</table> 
    </body>
</html>
 