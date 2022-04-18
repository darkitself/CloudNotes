<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="/api/notes/create" method="post">
        <div><label> Title : <input type="text" name="name"/> </label></div>
        <div><textarea name="note"></textarea></div>
        <div><input type="submit" value="Create"/></div>
    </form>
</@c.page>