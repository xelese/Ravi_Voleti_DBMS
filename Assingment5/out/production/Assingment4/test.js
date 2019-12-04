require('./db')();
const universityDao = require("./daos/university.dao.server");

// general test

//universityDao.populate();

//universityDao.findAllStudents().then(newUser => console.log(newUser));

//universityDao.findStudentById(123).then(newUser => console.log(newUser));

//universityDao.deleteStudent(234).then(console.log);

//universityDao.truncateDatabase();

//universityDao.findAllQuestions().then(newUser => console.log(newUser));

universityDao.answerQuestion(123, 321, true)