package net.ruippeixotog.scalascraper.browser

import java.io.File

import net.ruippeixotog.scalascraper.model.Document

trait Browser {
  def userAgent: String

  def get(url: String): Document
  def post(url: String, form: Map[String, String]): Document

  def parseFile(file: File, charset: String): Document
  def parseFile(file: File): Document = parseFile(file, "UTF-8")
  def parseFile(path: String, charset: String): Document = parseFile(new File(path), charset)
  def parseFile(path: String): Document = parseFile(new File(path), "UTF-8")

  def parseString(html: String): Document

  def cookies(url: String): Map[String, String]
  def clearCookies(): Unit
}
