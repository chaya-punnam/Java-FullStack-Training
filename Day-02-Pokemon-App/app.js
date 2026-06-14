const HtmlBody=document.getElementById("body")
for(let i=1;i<1001;i++)
{
    const Img=document.createElement("img")
    Img.setAttribute("src",`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${i}.png`)
    HtmlBody.append(Img)
}