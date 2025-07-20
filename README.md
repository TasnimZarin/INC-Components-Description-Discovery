# Ontology-Based Description and Discovery of In-Network Computing (INC) Components

This repository contains the ontology, semantic matching algorithm, example queries, and evaluation results for the project titled:

📄 **An Ontology-Based Model for In-Network Computing Components Description and Discovery**  
Presented at the *2024 International Conference on Network and Service Management (CNSM)*

---

## 📁 Repository Structure

- `INCDescription/` – OWL ontology developed in Protégé
- `INCDiscovery/` – Semantic matcher implementation and discovery logic (in Python/Java)
- `Queries/` – Example SQWRL rules and semantic queries
- `Results/` – Performance evaluation
- `Paper/` – Published paper (PDF)

---

## 🚀 Project Overview

This project aims to enable the semantic description and discovery of In-Network Computing (INC) components for latency-sensitive applications, such as holographic streaming. The system uses an ontology-based model to describe component capabilities — covering both functional and non-functional specifications — and a semantic matchmaker to retrieve contextually relevant resources based on user requirements.

### 🔹 **What is In-Network Computing?
INC refers to executing computing tasks directly within the network — using programmable switches and Smart NICs — rather than relying on distant cloud servers. This reduces latency, minimizes network congestion, and enhances real-time performance, which is essential for applications like Holographic-Type Communication.

### 🔹 **Why Use Ontology?
Ontology provides a formal, machine-readable structure to define and relate domain concepts. It enables semantic annotation, automated service discovery, and reasoning by offering a shared vocabulary. In this project, ontology enhances component description accuracy and allows context-aware matchmaking between service requests and INC resources.

---

## 🛠️ Tools & Technologies

| Tool             | Purpose                                       |
|----------------  |---------------------------------------------- |
| Protégé 5.6.3    | Ontology modeling                             |
| OWL/SWRL/SQWRL   | Rule and query language for reasoning         |
| Java / Python    | Matcher implementation                        |
| Excel / Charts   | Query performance evaluation and visualization|

---

## 📊 Results

- Enabled accurate, context-driven component discovery
- Response time in matching INC resources based on query complexity and retrived instances
- Scalability of the systen for data retrieval
- Improved semantic flexibility compared to keyword-based systems

> 📈 Full evaluation charts and metrics are available in the `Results/` folder

---
