<#import "parts/common.ftlh" as c>

<@c.page>
    <div>
        <a href="/api/main">Main page</a>
    </div>
    <form id="uploadbanner" enctype="multipart/form-data" method="post" action="/api/export/restore">
        <input id="fileupload" name="file" type="file"/>
        <input type="submit" value="Submit" id="submit" />
    </form>
    <form method="get" action="/api/export/download">
        <input type="submit" value="Выгрузить мои заметки"/>
    </form>
</@c.page>