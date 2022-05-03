<#import "parts/common.ftlh" as c>

<@c.page>
    <a href="/api/notes">Notes list</a>
    <form method="post" action="/api/notes/update/${response.note.id}">
        <div><label>
            <input type="text" name="name" size="40" value="${response.note.name}">
        </label></div>
        <div><label>
            <textarea <#if response.role == 'VIEWER'>readonly</#if> name="note" rows="5">${response.note.note}</textarea>
        </label></div>
        <p><input type="submit" value="Update"></p>
    </form>
</@c.page>