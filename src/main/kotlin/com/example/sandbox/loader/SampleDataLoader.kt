package com.example.sandbox.loader;

import com.example.sandbox.config.*
import com.example.sandbox.data.*
import com.example.sandbox.entity.*
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.*
import org.springframework.stereotype.*
import java.io.*
import java.util.*
import java.util.logging.*
import javax.annotation.*
import kotlin.reflect.*

@Component
class SampleDataLoader(private val sampleDataNameProperties: SampleDataNameProperties) {
    private val log: Logger = Logger.getLogger("SampleDataLoader")

    @PostConstruct
    fun loadingTargetData() {
//        sampleDataNameProperties.entities.forEach { name ->
//            process(Class.forName(name).kotlin)
//        }
        process(SampleData1::class)
        process(SampleData2::class)
    }

    fun <T : Any> process(klass: KClass<T>) {
        val name: String = klass.simpleName
                ?: throw RuntimeException("No such sample data class.")
        try {
            run {
                val inputStream: InputStream =
                        FileInputStream("/excel/$name.xlsx")
                val wb = XSSFWorkbook(inputStream)
                val sheet: XSSFSheet = wb.getSheetAt(0)
                val rows: Iterator<Row> = sheet.rowIterator()
                val map: MutableMap<String, Any?> = mutableMapOf()
                rows.forEach { row:
                               Row ->
                    run {
                        val cells: Iterator<Cell> = row.cellIterator()
                        val list: MutableList<String?> = LinkedList()
                        cells.forEach { cell:
                                        Cell ->
                            list.add(cell.stringCellValue)
                        }
                        val constructors = klass.java.constructors
                        for (constructor in constructors) {
                            if (constructor.parameters.size == 1) {
                                map[list[0]
                                        ?: throw RuntimeException("list[0] is non-null because key for map.")] =
                                        constructor.newInstance(list)
                            }
                        }
                    }
                }
                log.info("$name's Excel data loaded -> $map")
                SampleData.data[name] = map
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
