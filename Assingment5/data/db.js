module.exports = function () {
    const mongoose = require('mongoose');
    const databaseName = 'white-board';
    var connectionString =
        'mongodb+srv://admin:4657Ravi598!@cluster0-9icjs.mongodb.net/';
    connectionString += databaseName;
    mongoose.connect(connectionString);
};
