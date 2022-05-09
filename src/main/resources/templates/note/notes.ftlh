<#import "../parts/common.ftlh" as c>
<@c.page>
    <a href="/api/main">Main page</a><br>
    <a href="/api/note/create">Create note</a>
    <div>Notes</div>
    <#list response.getUserNotes() as note>
        <div>
            <form action="/api/note/delete/${note.getId()}" method="post">
                <a href="/api/note/${note.getId()}"><b>${note.getName()}</b></a> <input type="submit" value="Delete"/>
            </form>
        </div>
    </#list>

</@c.page>