<#import "../parts/common.ftlh" as c>

<@c.page>
    <a href="/api/note/all">Notes list</a>
    <form method="post" action="/api/note/update/${response.note.id}">
        <div><label>
            <input type="text" name="name" size="40" value="${response.note.name}">
        </label></div>
        <div><label>
            <textarea name="note" rows="5">${response.note.note}</textarea>
        </label></div>
        <p><input type="submit" value="Update"></p>
    </form>
</@c.page>