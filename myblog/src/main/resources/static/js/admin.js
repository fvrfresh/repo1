const RecycleBin = {template: '<div>Recycle Bin</div>'};
const Articles = {template: '<div>Articles</div>'};
const Editor = {template: '<div class="container">\n' +
        '        <div class="row mt-5">\n' +
        '            <div class="col-md-8">\n' +
        '                <form method="post">\n' +
        '\n' +
        '                    <div class="form-group">\n' +
        '                        <label for="title">Title:</label>\n' +
        '                        <input type="text" id="title" placeholder="Title" autocomplete="off" class="form-control"/>\n' +
        '                    </div>\n' +
        '\n' +
        '                    <div class="form-group">\n' +
        '                        <label for="content">Content:</label>\n' +
        '                        <textarea type="text" rows="4" id="content" placeholder="Content" class="form-control" autocomplete="off"></textarea>\n' +
        '                    </div>\n' +
        '\n' +
        '                    <button class="btn btn-primary" type="submit">Submit form</button>\n' +
        '                </form>\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>'};
const routes = [
    { path: '/articles', component: Articles },
    { path: '/editor', component: Editor },
    { path: '/recycle', component: RecycleBin }
];
const router = new VueRouter({
    routes // short for `routes: routes`
});
var vm = new Vue({
    router
}).$mount('#app');