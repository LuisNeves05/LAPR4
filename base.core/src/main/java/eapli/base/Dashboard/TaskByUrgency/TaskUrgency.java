package eapli.base.Dashboard.TaskByUrgency;


public class TaskUrgency {

    public static String taskByUrgencyList(){
        StringBuilder s = new StringBuilder();

        s.append("<!-- DATA TABLE-->\n" +
                "            <section class=\"p-t-20\">\n" +
                "                <div class=\"containerS\">\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-md-12\">\n" +
                "                            <h3 class=\"title-5 m-b-35\">Tarefas por Urgencia</h3>\n" +
                "                            <div class=\"table-data__tool\">\n" +
                "                                <div class=\"table-data__tool-left\">\n" +
                "                                    <div class=\"rs-select2--light rs-select2--md\">\n" +
                "                                        <select class=\"js-select2\" name=\"property\">\n" +
                "                                            <option selected=\"selected\">All Properties</option>\n" +
                "                                            <option value=\"\">Option 1</option>\n" +
                "                                            <option value=\"\">Option 2</option>\n" +
                "                                        </select>\n" +
                "                                        <div class=\"dropDownSelect2\"></div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"rs-select2--light rs-select2--sm\">\n" +
                "                                        <select class=\"js-select2\" name=\"time\">\n" +
                "                                            <option selected=\"selected\">Today</option>\n" +
                "                                            <option value=\"\">3 Days</option>\n" +
                "                                            <option value=\"\">1 Week</option>\n" +
                "                                        </select>\n" +
                "                                        <div class=\"dropDownSelect2\"></div>\n" +
                "                                    </div>\n" +
                "                                    <button class=\"au-btn-filter\">\n" +
                "                                        <i class=\"zmdi zmdi-filter-list\"></i>filters</button>\n" +
                "                                </div>\n" +
                "                                <div class=\"table-data__tool-right\">\n" +
                "                                    <button class=\"au-btn au-btn-icon au-btn--green au-btn--small\">\n" +
                "                                        <i class=\"zmdi zmdi-plus\"></i>add item</button>\n" +
                "                                    <div class=\"rs-select2--dark rs-select2--sm rs-select2--dark2\">\n" +
                "                                        <select class=\"js-select2\" name=\"type\">\n" +
                "                                            <option selected=\"selected\">Export</option>\n" +
                "                                            <option value=\"\">Option 1</option>\n" +
                "                                            <option value=\"\">Option 2</option>\n" +
                "                                        </select>\n" +
                "                                        <div class=\"dropDownSelect2\"></div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                            <div class=\"table-responsive table-responsive-data2\">\n" +
                "                                <table class=\"table table-data2\">\n" +
                "                                    <thead>\n" +
                "                                        <tr>\n" +
                "                                            <th>\n" +
                "                                                <label class=\"au-checkbox\">\n" +
                "                                                    <input type=\"checkbox\">\n" +
                "                                                    <span class=\"au-checkmark\"></span>\n" +
                "                                                </label>\n" +
                "                                            </th>\n" +
                "                                            <th>name</th>\n" +
                "                                            <th>email</th>\n" +
                "                                            <th>description</th>\n" +
                "                                            <th>date</th>\n" +
                "                                            <th>status</th>\n" +
                "                                            <th>price</th>\n" +
                "                                            <th></th>\n" +
                "                                        </tr>\n" +
                "                                    </thead>\n" +
                "                                    <tbody>\n" +
                "                                        <tr class=\"tr-shadow\">\n" +
                "                                            <td>\n" +
                "                                                <label class=\"au-checkbox\">\n" +
                "                                                    <input type=\"checkbox\">\n" +
                "                                                    <span class=\"au-checkmark\"></span>\n" +
                "                                                </label>\n" +
                "                                            </td>\n" +
                "                                            <td>Lori Lynch</td>\n" +
                "                                            <td>\n" +
                "                                                <span class=\"block-email\">lori@example.com</span>\n" +
                "                                            </td>\n" +
                "                                            <td class=\"desc\">Samsung S8 Black</td>\n" +
                "                                            <td>2018-09-27 02:12</td>\n" +
                "                                            <td>\n" +
                "                                                <span class=\"status--process\">Processed</span>\n" +
                "                                            </td>\n" +
                "                                            <td>$679.00</td>\n" +
                "                                            <td>\n" +
                "                                                <div class=\"table-data-feature\">\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Send\">\n" +
                "                                                        <i class=\"zmdi zmdi-mail-send\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Edit\">\n" +
                "                                                        <i class=\"zmdi zmdi-edit\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Delete\">\n" +
                "                                                        <i class=\"zmdi zmdi-delete\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"More\">\n" +
                "                                                        <i class=\"zmdi zmdi-more\"></i>\n" +
                "                                                    </button>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        <tr class=\"spacer\"></tr>\n" +
                "                                        <tr class=\"tr-shadow\">\n" +
                "                                            <td>\n" +
                "                                                <label class=\"au-checkbox\">\n" +
                "                                                    <input type=\"checkbox\">\n" +
                "                                                    <span class=\"au-checkmark\"></span>\n" +
                "                                                </label>\n" +
                "                                            </td>\n" +
                "                                            <td>Lori Lynch</td>\n" +
                "                                            <td>\n" +
                "                                                <span class=\"block-email\">john@example.com</span>\n" +
                "                                            </td>\n" +
                "                                            <td class=\"desc\">iPhone X 64Gb Grey</td>\n" +
                "                                            <td>2018-09-29 05:57</td>\n" +
                "                                            <td>\n" +
                "                                                <span class=\"status--process\">Processed</span>\n" +
                "                                            </td>\n" +
                "                                            <td>$999.00</td>\n" +
                "                                            <td>\n" +
                "                                                <div class=\"table-data-feature\">\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Send\">\n" +
                "                                                        <i class=\"zmdi zmdi-mail-send\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Edit\">\n" +
                "                                                        <i class=\"zmdi zmdi-edit\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Delete\">\n" +
                "                                                        <i class=\"zmdi zmdi-delete\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"More\">\n" +
                "                                                        <i class=\"zmdi zmdi-more\"></i>\n" +
                "                                                    </button>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        <tr class=\"spacer\"></tr>\n" +
                "                                        <tr class=\"tr-shadow\">\n" +
                "                                            <td>\n" +
                "                                                <label class=\"au-checkbox\">\n" +
                "                                                    <input type=\"checkbox\">\n" +
                "                                                    <span class=\"au-checkmark\"></span>\n" +
                "                                                </label>\n" +
                "                                            </td>\n" +
                "                                            <td>Lori Lynch</td>\n" +
                "                                            <td>\n" +
                "                                                <span class=\"block-email\">lyn@example.com</span>\n" +
                "                                            </td>\n" +
                "                                            <td class=\"desc\">iPhone X 256Gb Black</td>\n" +
                "                                            <td>2018-09-25 19:03</td>\n" +
                "                                            <td>\n" +
                "                                                <span class=\"status--denied\">Denied</span>\n" +
                "                                            </td>\n" +
                "                                            <td>$1199.00</td>\n" +
                "                                            <td>\n" +
                "                                                <div class=\"table-data-feature\">\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Send\">\n" +
                "                                                        <i class=\"zmdi zmdi-mail-send\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Edit\">\n" +
                "                                                        <i class=\"zmdi zmdi-edit\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Delete\">\n" +
                "                                                        <i class=\"zmdi zmdi-delete\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"More\">\n" +
                "                                                        <i class=\"zmdi zmdi-more\"></i>\n" +
                "                                                    </button>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "<!-- Comeca-->" +
                "                                        <tr class=\"spacer\"></tr>\n" +
                "                                        <tr class=\"tr-shadow\">\n" +
                "                                            <td>\n" +
                "                                                <label class=\"au-checkbox\">\n" +
                "                                                    <input type=\"checkbox\">\n" +
                "                                                    <span class=\"au-checkmark\"></span>\n" +
                "                                                </label>\n" +
                "                                            </td>\n" +
                "                                            <td>Lori Lynch</td>\n" +
                "                                            <td>\n" +
                "                                                <span class=\"block-email\">doe@example.com</span>\n" +
                "                                            </td>\n" +
                "                                            <td class=\"desc\">Camera C430W 4k</td>\n" +
                "                                            <td>2018-09-24 19:10</td>\n" +
                "                                            <td>\n" +
                "                                                <span class=\"status--process\">Processed</span>\n" +
                "                                            </td>\n" +
                "                                            <td>$699.00</td>\n" +
                "                                            <td>\n" +
                "                                                <div class=\"table-data-feature\">\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Send\">\n" +
                "                                                        <i class=\"zmdi zmdi-mail-send\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Edit\">\n" +
                "                                                        <i class=\"zmdi zmdi-edit\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Delete\">\n" +
                "                                                        <i class=\"zmdi zmdi-delete\"></i>\n" +
                "                                                    </button>\n" +
                "                                                    <button class=\"item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"More\">\n" +
                "                                                        <i class=\"zmdi zmdi-more\"></i>\n" +
                "                                                    </button>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "        <!-- Acaba aqui -->                    " +
                "                                    </tbody>\n" +
                "                                </table>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </section>\n" +
                "            <!-- END DATA TABLE-->");

        return s.toString();
    }
}
