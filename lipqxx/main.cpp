/*
 * main.cpp
 *
 *  Created on: Dec 1, 2010
 *      Author: maycon
 */
#include <iostream>
#include <pqxx/pqxx>
#include <boost/timer.hpp>
#include <boost/date_time/posix_time/posix_time_types.hpp>

using namespace std;
using namespace pqxx;

int main(){
	//time counter start with current time
	//boost::timer count;

	boost::posix_time::ptime startTime = boost::posix_time::microsec_clock::local_time();
	boost::posix_time::time_duration startDuration( startTime.time_of_day() );

    try {
    	//Make the database connection
        connection Conn("user=postgres password=servidor dbname=teste hostaddr=127.0.0.1 port=5432");
        //cout << "Connected to " << Conn.dbname() << endl;

        //Make a new transaction to run queries
        work W(Conn, "List Cities");

        //Execute an query and receive the result
		result R = W.exec("SELECT id, city, state FROM cities");
		//cout << "Found " << R.size() << "employees:" << endl;

		//Print the results
		/*for (result::const_iterator r = R.begin(); r != R.end(); ++r) {
				cout << r[0].c_str() << " - " << r[1].c_str() << " - " << r[2].c_str() << endl;
		}*/

    }
    catch (const exception &e) {
        cerr << e.what() << endl;
        return 1;
    }

    //Print the elapsed time in seconds
    //cout << "Elapsed time: " << count.elapsed() << " seconds" << endl;

    boost::posix_time::ptime endTime = boost::posix_time::microsec_clock::local_time();
	boost::posix_time::time_duration endDuration( endTime.time_of_day() );

	double elapsed = endDuration.total_milliseconds() - startDuration.total_milliseconds();

	std::cout << "Elapsed time: " << elapsed/1000 << std::endl;

    return 0;
}

/*
#include <iostream>
#include <pqxx/pqxx>

using namespace std;
using namespace pqxx;

int main()
{
        try
        {
        		pqxx::connection C("dbname=test");
                cout << "Connected to " << C.dbname() << endl;

                work W(C, "Transaction");
                result R = W.exec("SELECT name FROM employee");
                cout << "Found " << R.size() << "employees:" << endl;

                for (result::const_iterator r = R.begin(); r != R.end(); ++r) {
                        cout << r[0].c_str() << endl;
                }
                cout << "Doubling all employees' salaries..." << endl;

                W.exec("UPDATE employee SET salary=salary*2");
                cout << "Making changes definite: ";
                W.commit();
                cout << "ok." << endl;
        }
        catch (const exception &e)
        {
                cerr << e.what() << endl;
                return 1;
        }
        return 0;
}*/
