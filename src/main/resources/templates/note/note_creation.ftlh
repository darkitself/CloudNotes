<#import "../parts/common.ftlh" as c>

<@c.page>
    <form action="/api/note/create" method="post">
        <div><label> Title : <input type="text" name="name"/> </label></div>
        <div><label>
                <textarea name="note"></textarea>
            </label></div>
        <div><input type="submit" value="Create"/></div>
    </form>
</@c.page>